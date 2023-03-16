package com.gandalgom.sample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val flowStepNumber = arguments?.getInt("flowStepNumber")

        if (flowStepNumber == 2) {
            return inflater.inflate(R.layout.fragment_flow_step_two, container, false)
        }
        return inflater.inflate(R.layout.fragment_flow_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.next_step_button).setOnClickListener {}

        view.findViewById<View>(R.id.finish_button).setOnClickListener {}
    }
}