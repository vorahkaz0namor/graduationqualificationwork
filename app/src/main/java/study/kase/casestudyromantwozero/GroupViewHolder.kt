package study.kase.casestudyromantwozero

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val artistNameTextView: TextView = itemView.findViewById(R.id.artist_name_text_view)
    private val artistRoleTextView: TextView = itemView.findViewById(R.id.artist_role_text_view)
    fun bind(group: Group) {
        artistNameTextView.text = group.artistName
        artistRoleTextView.text = group.artistRole
    }
}