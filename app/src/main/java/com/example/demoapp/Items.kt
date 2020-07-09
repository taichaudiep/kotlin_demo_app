package com.example.demoapp

class Items(val title: String, val price: String, val isOnline: Boolean) {
    companion object {
        private var lastIndexItem = 0

        fun createItems(num: Int): ArrayList<Items> {
            val items = ArrayList<Items>()
            for (i in 1..num) {
                items.add(Items("Item $i", "${i * 1000}", i <= num / 2))
            }
            return items
        }
    }
}