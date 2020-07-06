package com.aliceresponde.mercadoco.domain

import com.aliceresponde.mercadoco.data.repository.Repository
import com.aliceresponde.mercadoco.ui.model.UiItem

class SearchUseCaseImp(private val repository: Repository) :
    SearchUseCase {
    override suspend fun searchItem(input: String): List<UiItem> {
        val result = repository.searchItem(input)
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