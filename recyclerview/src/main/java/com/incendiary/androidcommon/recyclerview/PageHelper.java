package com.incendiary.androidcommon.recyclerview;

public class PageHelper {

    private int page;
    private int firstPage;
    private int itemPerPage;
    private boolean onHold;
    private boolean onLastPage;

    private PageHelper(int page, int firstPage, int itemPerPage) {
        this.page = page;
        this.firstPage = firstPage;
        this.itemPerPage = itemPerPage;
    }

    public static PageHelper with(int firstPage, int itemPerPage) {
        return new PageHelperBuilder()
                .setFirstPage(firstPage)
                .setPage(firstPage)
                .setItemPerPage(itemPerPage)
                .create();
    }

    public static PageHelper getDefault() {
        return PageHelper.with(0, 10);
    }

    public synchronized void nextPage() {
        page++;
        onHold = false;
    }

    public synchronized void nextPage(int page) {
        this.page = page;
        onHold = false;
    }

    public synchronized void hold() {
        onHold = true;
    }

    public synchronized void reset() {
        page = firstPage;
        onHold = false;
        onLastPage = false;
    }

    public synchronized int getNextPage() {
        return page + 1;
    }

    public int getCurrentPage() {
        return page;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public boolean isOnHold() {
        return onHold;
    }

    public int getThreshold() {
        return page * itemPerPage;
    }

    public void setLastPage(boolean isLastPage) {
        this.onLastPage = isLastPage;
    }

    public boolean isOnLastPage() {
        return this.onLastPage;
    }

    public static class PageHelperBuilder {

        private int page;
        private int firstPage;
        private int itemPerPage;

        public PageHelperBuilder setPage(int page) {
            this.page = page;
            return this;
        }

        public PageHelperBuilder setFirstPage(int firstPage) {
            this.firstPage = firstPage;
            return this;
        }

        public PageHelperBuilder setItemPerPage(int itemPerPage) {
            this.itemPerPage = itemPerPage;
            return this;
        }

        public PageHelper create() {
            return new PageHelper(page, firstPage, itemPerPage);
        }
    }
}