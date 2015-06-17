package net.jitix.issuehub.util;

import java.util.List;
import javax.annotation.PostConstruct;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

@Service
public class ObjectMappingUtil {

    private MapperFactory mapperFactory;
    
    @PostConstruct
    public void createMapperFactory(){
        this.mapperFactory=new DefaultMapperFactory.Builder().build();
    }
        

    public <S, D> D map(S source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().map(source, destinationClass);
    }
    
    public <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationClass){
        return mapperFactory.getMapperFacade().mapAsList(sourceList, destinationClass);
    }

//    private static class A{
//        int a1;
//        int a2;
//        int b1;
//
//        @Override
//        public String toString() {
//            return "A{" + "a1=" + a1 + ", a2=" + a2 + ", b1=" + b1 + '}';
//        }
//        
//        
//    }
//    
//    private static class B{
//        int a1;
//        int a2;
//        int a3;
//
//        @Override
//        public String toString() {
//            return "B{" + "a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + '}';
//        }
//        
//        
//    }
//    public static void main(String[] args){
//        A a=new A();
//        a.a1=1;
//        a.a2=2;
//        a.a2=3;
//        
//        MapperFacade mapper = mapperFactory.getMapperFacade();
//        
//        B b = mapper.map(a, B.class);
//        
//        System.out.println(b);
//    }
}
