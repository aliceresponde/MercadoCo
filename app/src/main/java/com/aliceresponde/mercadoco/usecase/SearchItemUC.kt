package com.aliceresponde.mercadoco.usecase

import com.aliceresponde.mercadoco.data.repository.ItemsRepository
import com.aliceresponde.mercadoco.ui.model.UiItem

class SearchItemUC(private val itemsRepository: ItemsRepository) : SearchItemUseCase {
    override
    suspend operator fun invoke(input: String): List<UiItem> {
        val result = itemsRepository.searchItem(input)
        return result.map { item ->
            UiItem(
                item.id,
                item.title,
                "$ ${item.price}",
                item.thumbnail
            )
        }
    }
}