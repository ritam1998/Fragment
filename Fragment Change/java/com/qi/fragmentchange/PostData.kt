package com.qi.fragmentchange

interface PostData {

    fun onPost(data: String)

    companion object{
        private fun CustomModel() {}
    }
}
class CustomModel : PostData{

    override fun onPost(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


