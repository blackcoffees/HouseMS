package com.blackcoffees.housems.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReturnJsonData {
	public static String returnJsonDataSigleList(Pager pager, List<?> list){
		/*
		 * 一重list，返回json
		 * */
		if(pager.getTotal() == 0 || list.size() == 0){
			Map<String, Object> map2 = getReturnMap();
			if(pager.getTotal() == 0){
				pager.setTotal(list.size());
			}
			map2.put("pager", JSONObject.fromObject(pager).toString());
			map2.put("datas", list);
			map2.put("succ", true);
			map2.put("message", "");
			return JSONObject.fromObject(map2).toString();
		}
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for(int j=0;j<list.size();j++){
			Map<String, String> map = new HashMap<>();
			Field[] fields = list.get(j).getClass().getDeclaredFields();
			PropertyDescriptor pd = null;
			for(int i=0;i<fields.length;i++){
				String name = fields[i].getName();
				try {
					pd = new PropertyDescriptor(name, list.get(j).getClass());
					Method method = pd.getReadMethod();
					String value = String.valueOf(method.invoke(list.get(j)));
					map.put(name, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			result.add(map);
		}
		Map<String, Object> map2 = getReturnMap();
		map2.put("pager", JSONObject.fromObject(pager).toString());
		map2.put("datas", list);
		map2.put("succ", true);
		map2.put("message", "");
		return JSONObject.fromObject(map2).toString();
	}
	
	public static String returnJsonDataMultipleList(Pager pager, List<?> list){
		/*
		 * 多重list，返回json
		 * */
		if(pager.getTotal() == 0 || list.size() == 0){
			Map<String, Object> map2 = getReturnMap();
			map2.put("pager", JSONObject.fromObject(pager).toString());
			map2.put("data", list);
			map2.put("succ", true);
			map2.put("message", "");
			return JSONObject.fromObject(map2).toString();
		}
		List reslut = genJsonData(list);
		Map<String, Object> map = getReturnMap();
		map.put("pager", JSONObject.fromObject(pager).toString());
		map.put("datas", reslut);
		map.put("succ", true);
		map.put("message", "");
		return JSONObject.fromObject(map).toString();
	}
	
	
	public static List genJsonData(List<?> list){
		try {
			if(list.get(0) instanceof List){
				List<List<Map<String, String>>> jsonDatas = new ArrayList<List<Map<String, String>>>();
				for(int i=0;i<list.size();i++){
					List<Map<String, String>> jsonData = genJsonData((List)list.get(i));
					jsonDatas.add(jsonData);
				}
				return jsonDatas;
			}
			else{
				Class<?> clazz = list.get(0).getClass();
				List<Field> fields = new ArrayList<>();
				while(clazz != null){
					fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
					clazz = clazz.getSuperclass();
				}
				PropertyDescriptor pd = null;
				List<Map<String, String>> result = new ArrayList<Map<String, String>>();
				for(int i=0;i<list.size();i++){
					Map<String, String> valueMap = new HashMap<String, String>();
					for(int j=0;j<fields.size();j++){
						String fieldName = fields.get(j).getName();
						pd = new PropertyDescriptor(fieldName, list.get(0).getClass());
						Method method = pd.getReadMethod();
						String value = String.valueOf(method.invoke(list.get(i)));
						valueMap.put(fieldName, value);
					}
					result.add(valueMap);
				}
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
//	public static String currentReturnJsonArray(int total, List<?> list){
//		/*只能使用基础数据类型*/
//		if(total == 0 || list.size() == 0){
//			Map<String, Object> map2 = new HashMap<String, Object>();
//			map2.put("total", total);
//			map2.put("data", list);
//			map2.put("succ", true);
//			map2.put("message", "");
//			return JSONObject.fromObject(map2).toString();
//		}
//		List reslut = genJsonData(list);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("total", total);
//		map.put("data", reslut);
//		map.put("succ", true);
//		map.put("message", "");
//		return JSONArray.fromObject(map).toString();
//	}
	
	
//	public static String currentLineChartData(List<LineChart> list){
//		List<Map<String, Object>> mapList = new ArrayList<>();
//		for(int i=0;i<list.size();i++){
//			Map<String, Object> map = new HashMap<>();
//			map.put("name", list.get(i).getName());
//			map.put("data", JSONArray.fromObject(list.get(i).getDatas()).toString().replaceAll("\"", ""));
//			mapList.add(map);
//		}
//		Map result = new HashMap<>();
//		result.put("datas", mapList);
//		return JSONObject.fromObject(result).getString("datas");
//	}
	
	public static void main(String[] args){
		try{
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Map<String, Object> getReturnMap(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("pager", new Object());
		result.put("datas", new Object());
		result.put("succ", false);
		result.put("message", "");
		return result;
	}
}
