package sites



import grails.test.mixin.*
import org.junit.*

import groovy.mock.interceptor.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Item)
class ItemTests {

    void testLocalizeAnAdress() {
       def item = new Item(place: "San Esteban de Litera")
       def geocodingServiceMock = new MockFor(com.grails.plugins.localizable.GeocodingService)
       geocodingServiceMock.demand.findLatLngByAddress(){
           [lat:1, lng:2]
       }
       item.geocodingService = geocodingServiceMock.proxyInstance()
       item.localize()
       
       assertNotNull item.lat
       assertNotNull item.lng
    }
}
