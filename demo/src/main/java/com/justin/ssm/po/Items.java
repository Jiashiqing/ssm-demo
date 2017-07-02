package com.justin.ssm.po;

import com.justin.ssm.validation.validGroup1;
import com.justin.ssm.validation.validGroup2;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Items {
	//items(id,name,price,detail,pic,createtime)

	private int id;
	//校验名称在1到30字符之间
	//Message是提示校验出错显示的信息
	//group:此校验属于哪个分组，group可以定义多个分组
	@Size(min=1,max=30,message="{items.name.length.error}",groups={validGroup1.class})
	private String name;
	private int price;
	private String detail;
	private String pic;
	//非空校验
	@NotNull(message="{items.createtime.isNull}",groups={validGroup2.class})
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price
				+ ", detail=" + detail + ", pic=" + pic + ", createtime="
				+ createtime + "]";
	}
}
