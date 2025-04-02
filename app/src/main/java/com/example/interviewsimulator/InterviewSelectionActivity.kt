package com.example.interviewsimulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.interviewsimulator.databinding.ActivityInterviewSelectionBinding

class InterviewSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInterviewSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Back button click
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Interview type selections
        binding.cvTechnical.setOnClickListener {
            handleInterviewTypeSelection("technical")
        }

        binding.cvSales.setOnClickListener {
            handleInterviewTypeSelection("sales")
        }

        binding.cvProductManager.setOnClickListener {
            handleInterviewTypeSelection("product_manager")
        }

        binding.cvSoftwareEngineer.setOnClickListener {
            handleInterviewTypeSelection("software_engineer")
        }

        binding.cvProductDesigner.setOnClickListener {
            handleInterviewTypeSelection("product_designer")
        }

        // Start simulation button
        binding.btnStartSimulation.setOnClickListener {
            startSimulation()
        }
    }

    private fun handleInterviewTypeSelection(type: String) {
        // Store the selected interview type
        selectedInterviewType = type
        
        // Visual feedback for selection (you can add custom implementation)
        Toast.makeText(this, "Selected: $type", Toast.LENGTH_SHORT).show()
    }

    private fun startSimulation() {
        // Get selected difficulty level
        val difficulty = when {
            binding.rbEasy.isChecked -> "easy"
            binding.rbNormal.isChecked -> "normal"
            binding.rbHard.isChecked -> "hard"
            else -> null
        }

        if (selectedInterviewType == null) {
            Toast.makeText(this, "Por favor seleccione un tipo de entrevista", Toast.LENGTH_SHORT).show()
            return
        }

        if (difficulty == null) {
            Toast.makeText(this, "Por favor seleccione un nivel de dificultad", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Start the interview simulation activity with selected type and difficulty
        // Intent to start the simulation can be added here
    }

    companion object {
        private var selectedInterviewType: String? = null
    }
}