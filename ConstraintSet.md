# ConstrainSet
## Basic usage
1. Construct ConstraintSet object, eg.  
    a) mConstraintSet.clone(mContentWrapper);  
    b) mConstraintSetBackUp.clone(mConstraintSet);  
2. Common mehod, eg.  
    a) mConstraintSet.constrainWidth(R.id.title_tv, 300);  
    b) mConstraintSet.connect(R.id.chooser, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);  
    c) mConstraintSet.center(R.id.chooser, R.id.title_tv, ConstraintSet.TOP, 0, R.id.changer_btn, ConstraintSet.BOTTOM, 0, 0.5f);  