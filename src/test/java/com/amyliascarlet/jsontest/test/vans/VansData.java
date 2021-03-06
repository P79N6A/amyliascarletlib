package com.amyliascarlet.jsontest.test.vans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xiaolin_kxl on 16/12/28.
 */
public class VansData implements Serializable{

    public int[] textures;
    public ArrayList<String> images;
    public VansObject object;
    public VansMetaData metadata;
    public ArrayList<VansGeometry> geometries;
    public ArrayList<VansAnimation> animations;
    public Object materials;

}