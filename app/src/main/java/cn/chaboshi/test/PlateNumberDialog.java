package cn.chaboshi.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * ${车牌号汉字选择弹框}
 *
 * @author Su
 * @create 2018-07-24-11:36
 */
public class PlateNumberDialog extends BottomSheetDialog {

    private Context mContext;
    private OnItemSelectedListener mSelectedListener;

    private static List<String> sStringList = new ArrayList<>();

    static {
        sStringList.add("京");
        sStringList.add("津");
        sStringList.add("冀");
        sStringList.add("晋");
        sStringList.add("蒙");
        sStringList.add("辽");
        sStringList.add("吉");
        sStringList.add("黑");
        sStringList.add("沪");
        sStringList.add("苏");
        sStringList.add("浙");
        sStringList.add("皖");
        sStringList.add("闽");
        sStringList.add("赣");
        sStringList.add("鲁");
        sStringList.add("豫");
        sStringList.add("鄂");
        sStringList.add("湘");
        sStringList.add("粤");
        sStringList.add("桂");
        sStringList.add("琼");
        sStringList.add("渝");
        sStringList.add("川");
        sStringList.add("贵");
        sStringList.add("云");
        sStringList.add("藏");
        sStringList.add("陕");
        sStringList.add("甘");
        sStringList.add("青");
        sStringList.add("宁");
        sStringList.add("新");
    }


    public PlateNumberDialog(@NonNull Context context) {
        super(context);
        mContext = context;
        init();
    }

    private void init() {
        //初始化整体布局
        RecyclerView rcv = new RecyclerView(mContext);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dip2px(mContext, 5), dip2px(mContext, 5), dip2px(mContext, 5), dip2px(mContext, 5));
        rcv.setLayoutParams(lp);
        rcv.setLayoutManager(new GridLayoutManager(mContext, 5));
        rcv.setAdapter(new PlateAdapter());
        setContentView(rcv);
    }

    public void show() {
        super.show();
    }

    public void show(OnItemSelectedListener listener) {
        super.show();
        mSelectedListener = listener;
    }

    //省适配器
    class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.PlateHolder> {

        @NonNull
        @Override
        public PlateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            RelativeLayout rl = new RelativeLayout(mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(dip2px(mContext, 5), dip2px(mContext, 5), dip2px(mContext, 5), dip2px(mContext, 5));
            rl.setLayoutParams(layoutParams);

            TextView textView = new TextView(mContext);
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setTextColor(Color.parseColor("#FF2C241F"));

            //代码设置?android:attr/selectableItemBackground
            TypedValue typedValue = new TypedValue();
            int[] attribute = new int[]{android.R.attr.selectableItemBackground};
            TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(typedValue.resourceId, attribute);

            textView.setBackground(typedArray.getDrawable(0));
            textView.setPadding(0, dip2px(mContext, 5), 0, dip2px(mContext, 5));
            textView.getPaint().setFakeBoldText(true);
            textView.setGravity(Gravity.CENTER);

            rl.setClickable(true);
            textView.setClickable(true);
            rl.addView(textView);
            rl.setBackgroundColor(Color.parseColor("#f2f2f2"));
            return new PlateHolder(rl);
        }

        @Override
        public void onBindViewHolder(@NonNull PlateHolder holder, final int position) {
            holder.mTextView.setText(sStringList.get(position));
            if (mSelectedListener != null) {
                holder.mTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mSelectedListener.onSelectedListener(sStringList.get(position));
                        PlateNumberDialog.super.dismiss();
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return sStringList.size();
        }

        class PlateHolder extends RecyclerView.ViewHolder {

            TextView mTextView;

            public PlateHolder(View itemView) {
                super(itemView);
                RelativeLayout rl = (RelativeLayout) itemView;
                mTextView = (TextView) rl.getChildAt(0);
            }
        }
    }


    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mSelectedListener = listener;
    }


    interface OnItemSelectedListener {
        void onSelectedListener(String province);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
