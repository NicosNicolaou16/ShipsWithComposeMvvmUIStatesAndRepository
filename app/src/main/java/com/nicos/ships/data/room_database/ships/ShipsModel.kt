package com.nicos.ships.data.room_database.ships

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase
import com.nicos.ships.data.room_database.type_converter.ConverterMission
import com.nicos.ships.data.room_database.type_converter.ConverterPosition
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@Entity(indices = [Index(value = ["ship_id"], unique = true)])
data class ShipsModel(
    @PrimaryKey
    var ship_id: String,
    var ship_name: String?,
    var ship_type: String?,
    var active: Boolean?,
    var imo: Long?,
    var mmsi: Long?,
    var abs: Long?,
    @SerializedName("class")
    var clazz: Long?,
    var weight_lbs: Long?,
    var year_built: Long?,
    var home_port: String?,
    var status: String?,
    var speed_kn: Int?,
    var course_deg: String?,
    @TypeConverters(ConverterPosition::class)
    var position: PositionModel,
    var positionId: Long,
    var successful_landings: Int?,
    var attempted_landings: Int?,
    @TypeConverters(ConverterMission::class)
    var missions: MutableList<MissionsModel>,
    var url: String?,
    var image: String?,
) {

    constructor() : this(
        "",
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        PositionModel(),
        -1,
        null,
        null,
        mutableListOf(),
        null,
        null
    )

    companion object {
        suspend fun insertTheShips(
            shipsModelList: MutableList<ShipsModel>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                saveShips(shipsModelList, myRoomDatabase).collect()
                emit(
                    myRoomDatabase.shipDao().getAllShips()
                ) //return with flow - emit all ships data
            }

        private suspend fun saveShips(
            shipsModelList: MutableList<ShipsModel>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                val shipsModelListSaved = mutableListOf<ShipsModel>()
                //delete the position and mission objects because their ids are auto generate (autoGenerate = true)
                myRoomDatabase.positionDao().deleteAll()
                myRoomDatabase.shipDao()
                    .insertOrReplaceList(shipsModelList) //insert the ship
                shipsModelList.forEach { ship ->
                    savePosition(ship, myRoomDatabase)
                    saveMissions(ship, myRoomDatabase)
                    shipsModelListSaved.add(ship) //add the ship data into list to insert into the database
                }
                emit(shipsModelListSaved)
            }

        /**
         * inset position object - one to one
         * */
        private suspend fun savePosition(ship: ShipsModel, myRoomDatabase: MyRoomDatabase) {
            PositionModel.insertThePosition(ship.position, myRoomDatabase).collect {
                ship.positionId =
                    it.positionId //get the position_id from PositionModel and assign to positionId (ShipModel)
            }
        }

        private suspend fun saveMissions(ship: ShipsModel, myRoomDatabase: MyRoomDatabase) {
            MissionsModel.insertTheMissions(
                ship.missions,
                ship.ship_id,
                myRoomDatabase
            ) //insert missions list object
        }

        suspend fun getShipById(id: String, myRoomDatabase: MyRoomDatabase): ShipsModel? {
            val ship = myRoomDatabase.shipDao().getShipById(id)
            val missions = myRoomDatabase.missionsDao().getAllMissionsByShipId(id)
            val position = myRoomDatabase.positionDao().getPositionById(ship?.positionId ?: -1)
            ship?.missions = missions
            if (position != null) {
                ship?.position = position
            }
            return ship
        }
    }
}