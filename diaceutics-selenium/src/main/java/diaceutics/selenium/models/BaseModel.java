package diaceutics.selenium.models;

import aquality.selenium.core.logging.Logger;

import java.lang.reflect.Field;
import java.util.Arrays;

public class BaseModel {

    private int depth = 3;

    public void setReflectionFieldValue(String modelField, String value) {
        Class updatedClass = this.getClass();
        for (int i = 0; i < depth; i++) {
            if (Arrays.stream(updatedClass.getDeclaredFields()).anyMatch(o -> o.getName().equals(modelField))) {
                try {
                    Field declaredField = updatedClass.getDeclaredField(modelField);
                    declaredField.setAccessible(true);
                    declaredField.set(this, value);
                    break;
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    Logger.getInstance().fatal(e.getMessage(), e);
                }
            } else {
                updatedClass = updatedClass.getSuperclass();
            }
        }
    }

    public String getReflectionFieldValue(String modelField) {
        Class updatedClass = this.getClass();
        String value = "";
        for (int i = 0; i < depth; i++) {
            if (Arrays.stream(updatedClass.getDeclaredFields()).anyMatch(o -> o.getName().equals(modelField))) {
                try {
                    Field declaredField = updatedClass.getDeclaredField(modelField);
                    declaredField.setAccessible(true);
                    value = (String) declaredField.get(this);
                    break;
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    Logger.getInstance().fatal(e.getMessage(), e);
                }
            } else {
                updatedClass = updatedClass.getSuperclass();
            }
        }

        return value;
    }
}
