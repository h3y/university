package com.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.HashMap;

/**
 * Created by Slavik Glodan on 19.12.2016.
 */
public class AjaxResponse {
    private static final Logger logger = Logger.getLogger(AjaxResponse.class);
    private ObjectMapper mapper = null;
    private final HashMap<String, Object> map = new HashMap<>();
    private SimpleModule module = null;

    public static AjaxResponse create() {
        return new AjaxResponse();
    }

    private enum Models {
        Category("categories"), User("users"), Device("devices"), Session("sessions"), Dose("doses"), Template("templates"), Terminal("terminals");
        private final String tag;

        private Models(String c) {
            tag = c;
        }

        static String getTag(Class<?> c) {
            return Models.valueOf(c.getSimpleName()).tag;
        }
    };

    public AjaxResponse put(String field, Object object) {
        map.put(field, object);
        return this;
    }

    public AjaxResponse put(Class<?> tag, Object object) {
        put(Models.getTag(tag), object);
        return this;
    }

//    public AjaxResponse withSerializerUser(Boolean extended, Boolean with_photo) {
//        module = new SimpleModule();
//        module.addSerializer(User.class, new UserSerializer(extended, with_photo));
//        return this;
//    }
//
//    public AjaxResponse withSerializerSession(Boolean extended) {
//        module = new SimpleModule();
//        module.addSerializer(Session.class, new SessionSerializer(extended));
//        module.addSerializer(User.class, new UserSerializer(false, false));
//        return this;
//    }

    public AjaxResponse result(int result) {
        map.put("result", result);
        return this;
    }

    @Override
    public String toString() {
        try {
            mapper = new ObjectMapper();
            if (!map.containsKey("result")) {
                map.put("result", 0);
            }
            if (module != null) {
                mapper.registerModule(module);
            }
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException ex) {
            logger.log(Level.FATAL, ex);
        }
        return null;
    }

}
