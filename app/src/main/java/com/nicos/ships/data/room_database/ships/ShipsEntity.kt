package com.nicos.ships.data.room_database.ships

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.nicos.ships.data.room_database.init_database.MyRoomDatabase
import com.nicos.ships.data.room_database.type_converter.ConverterMission
import com.nicos.ships.data.room_database.type_converter.ConverterPosition
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

@Entity(indices = [Index(value = ["id"], unique = true)])
data class ShipsEntity(
    @PrimaryKey
    @SerializedName("ship_id")
    var id: String,
    @SerializedName("ship_name")
    var shipName: String?,
    @SerializedName("ship_type")
    var shipType: String?,
    var active: Boolean?,
    var imo: Long?,
    var mmsi: Long?,
    var abs: Long?,
    @SerializedName("class")
    var clazz: Long?,
    @SerializedName("weight_lbs")
    var weightLbs: Long?,
    @SerializedName("year_built")
    var yearBuilt: Long?,
    @SerializedName("home_port")
    var homePort: String?,
    var status: String?,
    @SerializedName("speed_kn")
    var speedKn: Int?,
    @SerializedName("course_deg")
    var courseDeg: String?,
    @TypeConverters(ConverterPosition::class)
    var position: PositionEntity?,
    @SerializedName("successful_landings")
    var successfulLandings: Int?,
    @SerializedName("attempted_landings")
    var attemptedLandings: Int?,
    @TypeConverters(ConverterMission::class)
    var missions: MutableList<MissionsEntity>,
    var url: String?,
    var image: String?,
) {

    constructor() : this(
        "",
        shipName = null,
        shipType = null,
        active = null,
        imo = null,
        mmsi = null,
        abs = null,
        clazz = null,
        weightLbs = null,
        yearBuilt = null,
        homePort = null,
        status = null,
        speedKn = null,
        courseDeg = null,
        position = null,
        successfulLandings = null,
        attemptedLandings = null,
        missions = mutableListOf(),
        url = null,
        image = null
    )

    companion object {
        suspend fun insertTheShips(
            shipsEntityList: MutableList<ShipsEntity>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                saveShips(shipsEntityList, myRoomDatabase).collect()
                emit(
                    myRoomDatabase.shipDao().getAllShips()
                ) //return with flow - emit all ships data
            }

        private suspend fun saveShips(
            shipsEntityList: MutableList<ShipsEntity>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                val shipsEntityListSaved = mutableListOf<ShipsEntity>()
                //delete the position and mission objects because their ids are auto generate (autoGenerate = true)
                myRoomDatabase.positionDao().deleteAll()
                myRoomDatabase.missionsDao().deleteAll()
                //insert the ship model
                myRoomDatabase.shipDao().insertOrReplaceList(shipsEntityList)
                shipsEntityList.forEach { ship ->
                    savePosition(ship, myRoomDatabase)
                    saveMissions(ship, myRoomDatabase)
                    shipsEntityListSaved.add(ship) //add the ship data into list to insert into the database
                }
                emit(shipsEntityListSaved)
            }

        /**
         * inset position object - one to one
         * */
        private suspend fun savePosition(ship: ShipsEntity, myRoomDatabase: MyRoomDatabase) {
            PositionEntity.insertThePosition(
                positionEntity = ship.position,
                shipId = ship.id,
                myRoomDatabase = myRoomDatabase
            )
        }

        /**
         * insert missions one to many
         * */
        private suspend fun saveMissions(ship: ShipsEntity, myRoomDatabase: MyRoomDatabase) {
            MissionsEntity.insertTheMissions(
                missionsEntityList = ship.missions,
                shipId = ship.id,
                myRoomDatabase = myRoomDatabase
            ) //insert missions list object
        }

        suspend fun getShipById(id: String, myRoomDatabase: MyRoomDatabase): ShipsEntity? {
            val ship = myRoomDatabase.shipDao().getShipById(id)
            return ship
        }
    }
}