package com.gandalgom.sample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class FlowStepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val safeArgs: FlowStepFragmentArgs by navArgs()
        if (safeArgs.flowStepNumber == 2) {
            return inflater.inflate(R.layout.fragment_flow_step_two, container, false)
        }
        return inflater.inflate(R.layout.fragment_flow_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.next_step_button)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.move_to_step_two)
        )

        view.findViewById<Button>(R.id.finish_button)?.setOnClickListener {}
    }
}