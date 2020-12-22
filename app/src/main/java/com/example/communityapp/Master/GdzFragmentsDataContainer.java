package com.example.communityapp.Master;

public class GdzFragmentsDataContainer {

    private static String subjectFilter;
    private static int classIndexFilter;

    public static String getSubjectFilter() {
        return subjectFilter;
    }

    public static void setSubjectFilter(String subjectFilter) {
        GdzFragmentsDataContainer.subjectFilter = subjectFilter;
    }

    public static int getClassIndexFilter() {
        return classIndexFilter;
    }

    public static void setClassIndexFilter(int classIndexFilter) {
        GdzFragmentsDataContainer.classIndexFilter = classIndexFilter;
    }
}
