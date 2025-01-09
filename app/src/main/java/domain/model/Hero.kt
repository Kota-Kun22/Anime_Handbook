package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.anime_handbook.utiles.Constants.HERO_DATABASE_TABLE

/* represent the table in the our database so I will have to annotate it  */
@Entity(tableName = HERO_DATABASE_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val int:Int,
    val name:String,
    val image:String,
    val about:String,
    val rating :Double,
    val power:Int,
    val month:String,
    val day:String,
    val family:List<String>,
    val abilities:List<String>,
    val natureTypes:List<String>

)

