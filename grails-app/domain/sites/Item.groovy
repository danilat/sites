package sites

class Item {
    static belongsTo = [category: Category]
	String name
	String description
	String place
	
	Double lat
	Double lng
	
	static hasMany = [photo: Photo]
    static constraints = {
		name()
		description()
		place()
		lat(nullable:true)
		lng(nullable:true)
    }

	static mapping = {
		description type: 'text'
	}
}
