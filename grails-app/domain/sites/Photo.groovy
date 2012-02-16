package sites

import pl.burningice.plugins.image.ast.FileImageContainer 

@FileImageContainer(field = 'file')
class Photo {
    
    String name

    static constraints = {
    }
    
    String toString(){
        name
    }
}
