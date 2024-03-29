package com.poli.prevendasomie.domain.use_case.cliente_list

import com.poli.prevendasomie.R
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.toListarClientes
import com.poli.prevendasomie.domain.model.ListarClientes
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClientListUseCase @Inject constructor(private val repository: ClientsRepository) {

    operator fun invoke(): Flow<Resource<ListarClientes>> = flow {

        val currPage: Int = 0
        val request = Request.ListClientsRequest(

            call = "ListarClientes",
            param = listOf(
                Param.ParamListarClientes(
                    "N",
                    currPage.toString(),
                    "10"
                )
            )
        )

        try {
            emit(Resource.Loading<ListarClientes>())
            val clients = repository.getClientList(request).toListarClientes()
            emit(Resource.Success(clients))
        } catch (e: HttpException) {
            emit(Resource.Error<ListarClientes>(e.localizedMessage ?: R.string.on_http_error.toString()))
        } catch (e: IOException) {
            emit(Resource.Error<ListarClientes>(e.localizedMessage ?: R.string.on_http_error.toString()))
        }
    }
}
