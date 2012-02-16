package sites

class Item {
    transient def geocodingService
    static belongsTo = [category: Category]
    String name
    String description
    String place
    
    Double lat
    Double lng
    
    static hasMany = [photos: Photo]
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
    
    def localize(){
        def latLng = geocodingService.findLatLngByAddress(place)
        lat = latLng.lat
        lng = latLng.lng
        this
    }
}
