import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.crimedigital.premierleaguefixtures.databinding.ListItemMatchBinding
import com.example.crimedigital.premierleaguefixtures.model.MatchModel

class MatchAdapter : PagingDataAdapter<MatchModel, MatchAdapter.MatchViewHolder>(MATCH_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = ListItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class MatchViewHolder(private val binding: ListItemMatchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(match: MatchModel) {
            binding.apply {
                tvHomeTeam.text = match.HomeTeam
                tvAwayTeam.text = match.AwayTeam
                scoreHomeTeam.text = match.HomeTeamScore.toString()
                scoreAwayTeam.text = match.AwayTeamScore.toString()
                NumberMatch.text = match.MatchNumber.toString()
                NumberRound.text = match.RoundNumber.toString()
                tvDataUTC.text = match.DateUtc
            }
        }
    }

    companion object {
        private val MATCH_COMPARATOR = object : DiffUtil.ItemCallback<MatchModel>() {
            override fun areItemsTheSame(oldItem: MatchModel, newItem: MatchModel): Boolean {
                return oldItem.MatchNumber == newItem.MatchNumber
            }

            override fun areContentsTheSame(oldItem: MatchModel, newItem: MatchModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
