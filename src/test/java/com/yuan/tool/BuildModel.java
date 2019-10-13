package com.yuan.tool;

/**
 * FileName: BuildModel
 * Author:   yhl
 * Date:     2019/10/9 23:33
 * Description: 构建者模式
 */
public class BuildModel {
    private final String type;
    private final boolean ice;

    private BuildModel(Build build){
        this.type=build.type;
        this.ice=build.ice;
    }
    public String getType() {
        return type;
    }

    public boolean isIce() {
        return ice;
    }

    public static class Build{
        private final String type;
        private boolean ice;
        public Build(String type){
            this.type=type;
        }
        public Build ice(boolean ice){
            this.ice=ice;
            return this;
        }
        public BuildModel bulid(){
            return new BuildModel(this);
        }
    }

    public static void main(String[] args) {
        BuildModel buildModel = new Build("灰色").ice(true).bulid();
    }
}
