package com.laptrinhjavaweb.paging;

public class PageRequest implements Pageable {
	private Integer page;
	private Integer limit;

	// neu nhieu hon 3 tham so khong lam cach nay
	public PageRequest(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;

	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		return (this.page - 1) * this.limit;
	}

	@Override
	public Integer getLimit() {
		return this.limit;
	}

}
