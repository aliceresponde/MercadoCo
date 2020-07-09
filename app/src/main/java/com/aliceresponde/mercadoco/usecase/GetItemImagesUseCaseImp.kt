package com.aliceresponde.mercadoco.usecase

import com.aliceresponde.mercadoco.ui.detail.DetailRepository

class GetItemImagesUseCaseImp(private val detailRepository: DetailRepository) :
    GetItemImagesUseCase {
    override suspend fun invoke(id: String): List<String> {
        val response = detailRepository.getItemDetail(id)
        return response.map { it.secure_url }
    }
}
