package com.aliceresponde.mercadoco.ui.detail

class GetItemDescriptionUseCaseImp(private val repository: DetailRepository) :
    GetItemDescriptionUseCase {
    override suspend fun invoke(id: String): String {
         return repository.getItemDescription(id)
    }
}
