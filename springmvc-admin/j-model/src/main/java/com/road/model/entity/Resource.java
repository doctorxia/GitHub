package com.road.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {

	private Long id;

	private String name;

	private String url;

	private String description;

	private String icon;

	private Integer pid;

	private int seq;

	private int status;

	private int resourcetype;

	private Date createdate;

	private Integer createuser;

	private Date updatedate;

	private Integer updateuser;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(int resourcetype) {
		this.resourcetype = resourcetype;
	}

	public void setResourcetype(Byte resourcetype) {
		this.resourcetype = resourcetype;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Integer getCreateuser() {
		return createuser;
	}

	public void setCreateuser(Integer createuser) {
		this.createuser = createuser;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(Integer updateuser) {
		this.updateuser = updateuser;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", url=" + url
				+ ", description=" + description + ", icon=" + icon + ", pid="
				+ pid + ", seq=" + seq + ", status=" + status
				+ ", resourcetype=" + resourcetype + ", createdate="
				+ createdate + ", createuser=" + createuser + ", updatedate="
				+ updatedate + ", updateuser=" + updateuser + "]";
	}

}