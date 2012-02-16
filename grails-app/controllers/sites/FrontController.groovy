package sites

class FrontController {

    def index() { 
        def sites = Item.list()
        return [sites: sites]
    }
}
