package study.kase.casestudyromantwozero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActiviy : AppCompatActivity() {

    lateinit var groupRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val groupList: List<Group> = listOf(
            Group("Ирина", "вокал, бубен"),
            Group("Дмитрий", "ритм-гитара, вокал"),
            Group("Роман", "соло-гитара"),
            Group("Антон", "бас-гитара"),
            Group("Артур", "ударные")
        )
        groupRecyclerView=findViewById(R.id.group_recycler_view)
        groupRecyclerView.layoutManager=
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
            groupRecyclerView.adapter=GroupAdapter(groupList)
            groupRecyclerView.addItemDecoration(DividerItemDecoration(
            this, DividerItemDecoration.VERTICAL
            ))

    }
}