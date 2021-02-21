package fm.aeon.paymentaeon.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fm.aeon.paymentaeon.R
import fm.aeon.paymentaeon.models.Payment

class PaymentsAdapter(
    context: Context,
    private val data: List<Payment>
) : RecyclerView.Adapter<PaymentsAdapter.ViewHolder>() {

    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.payment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val payment = data[position]
        holder.amount.text = String.format("%.2f %s", payment.amount.toFloat(), payment.currency ?: "")
        holder.desc.text = payment.desc
        holder.created.text = payment.created.toString()
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amount: TextView = itemView.findViewById(R.id.amount)
        val desc: TextView = itemView.findViewById(R.id.desc)
        val created: TextView = itemView.findViewById(R.id.created)
    }
}
