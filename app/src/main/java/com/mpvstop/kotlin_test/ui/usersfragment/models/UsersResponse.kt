package com.mpvstop.kotlin_test.ui.usersfragment.models

data class UsersResponse(
	val results: List<ResultsItem?>? = null
)

//data class Dob(
//	val date: String? = null,
//	val age: Int? = null
//)
//
data class Id(
	val name: String? = null,
	val value: String? = null
)

data class Name(
	val last: String? = null,
	val title: String? = null,
	val first: String? = null
)

//data class Street(
//	val number: Int? = null,
//	val name: String? = null
//)
//
//data class Coordinates(
//	val latitude: String? = null,
//	val longitude: String? = null
//)
//
//data class Location(
//	val country: String? = null,
//	val city: String? = null,
//	val street: Street? = null,
//	val timezone: Timezone? = null,
//	val postcode: Int? = null,
//	val coordinates: Coordinates? = null,
//	val state: String? = null
//)
//
//data class Timezone(
//	val offset: String? = null,
//	val description: String? = null
//)

data class ResultsItem(
//	val nat: String? = null,
	val gender: String? = null,
	val phone: String? = null,
//	val dob: Dob? = null,
	val name: Name? = null,
	val registered: Registered? = null,
//	val location: Location? = null,
	val id: Id? = null,
//	val login: Login? = null,
	val cell: String? = null,
	val email: String? = null
//	val picture: Picture? = null
)

data class Registered(
	val date: String? = null,
	val age: Int? = null
)

//data class Picture(
//	val thumbnail: String? = null,
//	val large: String? = null,
//	val medium: String? = null
//)
//
//data class Login(
//	val sha1: String? = null,
//	val password: String? = null,
//	val salt: String? = null,
//	val sha256: String? = null,
//	val uuid: String? = null,
//	val username: String? = null,
//	val md5: String? = null
//)

