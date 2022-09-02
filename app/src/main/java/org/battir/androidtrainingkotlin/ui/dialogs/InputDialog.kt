package org.battir.androidtrainingkotlin.ui.dialogs


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import org.battir.androidtrainingkotlin.R


class InputDialog(val _mOnInputListener: OnInputListener) : DialogFragment() {

    interface OnInputListener {
        fun sendInput(input: String?)
    }

    var mOnInputListener: OnInputListener? = null

    final var edtName: EditText? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mOnInputListener = _mOnInputListener
        val builder = AlertDialog.Builder(activity!!)
        // Get the layout inflater
        val inflater = requireActivity().layoutInflater;
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        val v = inflater.inflate(R.layout.custom_dialog, null)
        //initialize the views
        edtName = v.findViewById<EditText>(R.id.edt_fullname)
        //set the interface view for the dialog builder
        builder.setView(v)
            // Add action buttons
            .setPositiveButton(R.string.ok,
                //instance of the Dialog and Int is the id of the button that is clicked
                DialogInterface.OnClickListener { dialog, id ->
                    mOnInputListener?.sendInput(edtName?.text.toString());
                })
            .setNegativeButton(R.string.cancel,
                //if the arguments aren’t used
                DialogInterface.OnClickListener { _, _ ->
                    //To dismiss the dialog, use one of the following
                    // getDialog()?.cancel()
                    //  getDialog()?.dismiss()
                    dismiss()

                })
        //You can use the following code to call the click handler for the dialog buttons
//        builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = dialogButonsClickLisitener))
//        //or
//        builder.setPositiveButton(R.string.ok, dialogButonsClickLisitener)
//
        //to disable dismissing the dialog when touch outside
        isCancelable = false
        //The return generates the dialog
        return builder.create()
    }

    //    val dialogButonsClickLisitener = { dialog: DialogInterface, which: Int ->
//        //write your code here
//        when(which){
//            DialogInterface.BUTTON_POSITIVE ->{
//
//            } DialogInterface.BUTTON_NEGATIVE ->{
//
//            } DialogInterface.BUTTON_NEUTRAL ->{
//
//            }
//        }
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.custom_dialog, container, false);
    }
}