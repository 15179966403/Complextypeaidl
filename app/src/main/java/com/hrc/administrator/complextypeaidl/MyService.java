package com.hrc.administrator.complextypeaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.hrc.administrator.complextypeaidl.baocun.Product;

import java.util.HashMap;
import java.util.Map;

public class MyService extends Service {
    public class MyServiceImpl extends IMyService.Stub{

        @Override
        public Product getProduct() throws RemoteException {
            Product product=new Product();
            product.setId(1234);
            product.setName("汽车");
            product.setPrice(30000);
            return product;
        }

        @Override
        public Map getMap(String country, Product product) throws RemoteException {
            Map map=new HashMap<String,String>();
            map.put("country",country);
            map.put("id",product.getId());
            map.put("name",product.getName());
            map.put("price",product.getPrice());
            map.put("produce",product);
            return map;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyServiceImpl();
    }
}
