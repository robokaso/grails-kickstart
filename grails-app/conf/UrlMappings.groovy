class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"/boil"(view:"/boil/index")
		"500"(view:'/error')
	}
}
