package comSrTummnuss.com.github.listadecompras.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import comSrTummnuss.com.github.kotlin_android_lista_de_compras.R
import comSrTummnuss.com.github.listadecompras.model.ItemModel


class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {


    private var items = listOf<ItemModel>()


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(item: ItemModel) {

            textView.text = item.name

            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(view)
    }

    /**
     * Método que retorna a quantidade de itens que serão exibidos.
     * @return A quantidade de itens na lista.
     */
    override fun getItemCount(): Int = items.size

    /**
     * Método chamado pelo RecyclerView para exibir os dados na posição especificada.
     * Este método atualiza o conteúdo do ViewHolder para refletir o item na posição dada.
     *
     * @param holder O ViewHolder que deve ser atualizado para representar o conteúdo do item na posição fornecida no conjunto de dados.
     * @param position A posição do item dentro do conjunto de dados do adaptador.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    /**
     * Método chamado para atualizar a lista de itens que serão exibidos.
     * Este método atualiza a lista de itens e notifica o RecyclerView que os dados mudaram.
     *
     * @param newItems A nova lista de itens que serão exibidos.
     */
    fun updateItems(newItems: List<ItemModel>) {
        // Atualiza a lista de itens.
        items = newItems
        // Notifica o RecyclerView que os dados mudaram.
        notifyDataSetChanged()
    }
}