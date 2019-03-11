package com.example.rcrespillo.searchml.Model

class Search {

    val site_id: String = ""
    val query: String = ""
    val paging: Paging? = null
    val results: List<Result>? = null
    val secondary_results: List<Any>? = null
    val related_results: List<Any>? = null
    val sort: Sort? = null
    val available_sorts: List<AvailableSort>? = null
    val filters: List<Filter>? = null
    val available_filters: List<AvailableFilter>? = null

    data class Paging(
        val total: Int,
        val offset: Int,
        val limit: Int,
        val primary_results: Int
    )

    data class Seller(
        val id: Int,
        val power_seller_status: String,
        val car_dealer: Boolean,
        val real_estate_agency: Boolean,
        val tags: List<String>
    )

    data class Installments(
        val quantity: Int,
        val amount: Double,
        val rate: Double,
        val currency_id: String
    )

    data class Address(
        val state_id: String,
        val state_name: String,
        val city_id: String,
        val city_name: String
    )

    data class Shipping(
        val free_shipping: Boolean,
        val mode: String,
        val tags: List<String>,
        val logistic_type: String,
        val store_pick_up: Boolean
    )

    data class Country(
        val id: String,
        val name: String
    )

    data class State(
        val id: String,
        val name: String
    )

    data class City(
        val id: String,
        val name: String
    )

    data class SellerAddress(
        val id: String,
        val comment: String,
        val address_line: String,
        val zip_code: String,
        val country: Country,
        val state: State,
        val city: City,
        val latitude: String,
        val longitude: String
    )

    data class Attribute(
        val value_struct: String,
        val attribute_group_id: String,
        val attribute_group_name: String,
        val source: Double,
        val id: String,
        val name: String,
        val value_id: String,
        val value_name: String
    )

    data class Reviews(
        val rating_average: Double,
        val total: Int
    )

    data class DifferentialPricing(
        val id: Int
    )

    data class Result(
        val id: String,
        val site_id: String,
        val title: String,
        val seller: Seller,
        val price: Double,
        val currency_id: String,
        val available_quantity: Int,
        val sold_quantity: Int,
        val buying_mode: String,
        val listing_type_id: String,
        val stop_time: String,
        val condition: String,
        val permalink: String,
        val thumbnail: String,
        val accepts_mercadopago: Boolean,
        val installments: Installments,
        val address: Address,
        val shipping: Shipping,
        val seller_address: SellerAddress,
        val attributes: List<Attribute>,
        val original_price: Int,
        val category_id: String,
        val official_store_id: String,
        val catalog_product_id: String,
        val reviews: Reviews,
        val tags: List<String>,
        val differential_pricing: DifferentialPricing
    )

    data class Sort(
        val id: String,
        val name: String
    )

    data class AvailableSort(
        val id: String,
        val name: String
    )

    data class PathFromRoot(
        val id: String,
        val name: String
    )

    data class Value(
        val id: String,
        val name: String,
        val path_from_root: List<PathFromRoot>
    )

    data class Filter(
        val id: String,
        val name: String,
        val type: String,
        val values: List<Value>
    )

    data class Value2(
        val id: String,
        val name: String,
        val results: Int
    )

    data class AvailableFilter(
        val id: String,
        val name: String,
        val type: String,
        val values: List<Value2>
    )
}