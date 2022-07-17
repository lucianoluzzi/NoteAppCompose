package nl.com.lucianoluzzi.noteappcompose.data.dataSource

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import nl.com.lucianoluzzi.noteappcompose.data.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * from note WHERE id = :id")
    fun getNote(id: Long): NoteEntity?
}