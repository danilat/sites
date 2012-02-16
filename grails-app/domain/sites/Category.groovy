package sites

class Category {
    String name
    
    static hasMany = [items: Item]

    static constraints = {
        name nullable:false, blank:false
    }
    
    String toString(){
        name
    }
}
