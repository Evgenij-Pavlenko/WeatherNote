package com.example.abschlussaufgabe.ui

import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragment
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.guestList.observe(viewLifecycleOwner) {
            binding.guestlist.adapter = GuestAdapter(it)
        }

        binding.addGuestButton.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddFragment())
        }
    }

}