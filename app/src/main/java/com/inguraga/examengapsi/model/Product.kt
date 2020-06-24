package com.inguraga.examengapsi.model

data class Current (
    var label: String? = null,
    var categoryId: String? = null
)


data class Navigation (
    var ancester: List<Any>? = null,
    var current: List<Current>? = null,
    var childs: List<Any>? = null
)

data class PlpResults (
    var label: String? = null,
    var plpState: PlpState? = null,
    var sortOptions: List<SortOption>? = null,
    var refinementGroups: List<RefinementGroup>? = null,
    var records: List<Record>? = null,
    var navigation: Navigation? = null
)


data class PlpState (
    var categoryId: String? = null,
    var currentSortOption: String? = null,
    var currentFilters: String? = null,
    var firstRecNum:Int = 0,
    var lastRecNum:Int = 0,
    var recsPerPage:Int = 0,
    var totalNumRecs:Int = 0,
    var originalSearchTerm: String? = null
)


data class Product (
    var status: Status? = null,
    var pageType: String? = null,
    var plpResults: PlpResults? = null
)


data class Record (
    var productId: String? = null,
    var skuRepositoryId: String? = null,
    var productDisplayName: String? = null,
    var productType: String? = null,
    var productRatingCount:Int = 0,
    var productAvgRating:Float = 0f,
    var listPrice:Float = 0f,
    var minimumListPrice:Float = 0f,
    var maximumListPrice:Float = 0f,
    var promoPrice:Float = 0f,
    var minimumPromoPrice:Float = 0f,
    var maximumPromoPrice:Float = 0f,
    var isHybrid :Boolean= false,
    var isMarketPlace:Boolean = false,
    var isImportationProduct :Boolean= false,
    var smImage: String? = null,
    var lgImage: String? = null,
    var xlImage: String? = null,
    var groupType: String? = null,
    var plpFlags: List<Any>? = null,
    var variantsColor: List<VariantsColor>? = null
)


data class Refinement (
    var count:Int = 0,
    var label: String? = null,
    var refinementId: String? = null,
    var selected:Boolean = false,
    var colorHex: String? = null
)


data class RefinementGroup (
    var name: String? = null,
    var refinement: List<Refinement>? = null,
    var multiSelect:Boolean = false,
    var dimensionName: String? = null
)


data class SortOption (
    var sortBy: String? = null,
    var label: String? = null
)


data class Status (
    var status: String? = null,
    var statusCode:Int = 0
)


data class VariantsColor (
    var colorName: String? = null,
    var colorHex: String? = null,
    var colorImageURL: String? = null
)