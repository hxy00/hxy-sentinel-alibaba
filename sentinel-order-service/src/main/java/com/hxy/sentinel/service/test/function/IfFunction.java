package com.hxy.sentinel.service.test.function;

import java.util.Map;

/**
 * 代替'if else' 和 'switch'的方法
 */
public class IfFunction<K> {

    private final Map<K, IFunction> map;

    /**
     * 通过map类型来保存对应的条件key和方法
     *
     * @param map a map
     */
    public IfFunction(Map<K, IFunction> map) {
        this.map = map;
    }

    /**
     * 添加条件
     *
     * @param key      需要验证的条件（key）
     * @param function 要执行的方法
     * @return this.
     */
    public IfFunction<K> add(K key, IFunction function) {
        this.map.put(key, function);
        return this;
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     *
     * @param key the key need to verify
     */
    public Map<String, Object> doIf(K key) {
        Map<String, Object> mapData = null;
        if (this.map.containsKey(key)) {
            mapData = map.get(key).invoke();
        }
        return mapData;
    }

    /**
     * 确定key是否存在，如果存在，则执行相应的方法。
     * 否则将执行默认方法
     *
     * @param key             需要验证的条件（key）
     * @param defaultFunction 要执行的方法
     */
    public Map<String, Object> doIfWithDefault(K key, IFunction defaultFunction) {
        Map<String, Object> mapData = null;
        if (this.map.containsKey(key)) {
            mapData = map.get(key).invoke();
        } else {
            mapData = defaultFunction.invoke();
        }
        return mapData;
    }
}
