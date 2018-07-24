# PlateNumberDialog
a plate number dialog utils
---
![](https://github.com/piscessu/PlateNumberDialog/blob/master/screenshots/a.png)
![](https://github.com/piscessu/PlateNumberDialog/blob/master/screenshots/b.png)
---

#### 用法
    PlateNumberDialog dialog = new PlateNumberDialog(this);
                dialog.setOnItemSelectedListener(new PlateNumberDialog.OnItemSelectedListener() {
                    @Override
                    public void onSelectedListener(String province) {
                        Toast.makeText(MainActivity.this, province, Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
