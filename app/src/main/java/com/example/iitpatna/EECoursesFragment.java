package com.example.iitpatna;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import kotlin.contracts.Returns;


public class EECoursesFragment extends Fragment {
RecyclerView EECourseRecyclerview;
ArrayList<EECourseModel> Course;

    public EECoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View = inflater.inflate(R.layout.fragment_e_e_courses, container, false);
        EECourseRecyclerview = View.findViewById(R.id.EECourseRecyclerView);
        EECourseRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));



        Course  =new ArrayList<>();
        Course.add(new EECourseModel("First Semester","B.Tech ",
                "EE102 Basic Electronics Laboratory","Nil","Nil","Nil", "Nil",
                "Circuit Analysis Techniques, Circuit elements, Simple RL and RC Circuits, Kirchoff's law, Nodal Analysis, Mesh Analysis, Linearity and Superposition, Source Transformations, Thevnin's and Norton's Theorems, Time Domain Response of RC, RL and RLC circuits, Sinusoidal Forcing Function, Phasor Relationship for R, L and C, Impedance and Admittance.\n" +
                        "\n" +
                        "Semiconductor Diode, Zener Diode, Rectifier Circuits, Clipper, Clamper, Bipolar Junction Transistors, Transistor Biasing, Transistor Small Signal Analysis, Transistor Amplifier, Operational Amplifiers, Op-amp Equivalent Circuit, Practical Op-amp Circuits, DC Offset, Constant Gain Multiplier, Voltage Summing, Voltage Buffer, Controlled Sources, Instrumentation Circuits, Active Filters and Oscillators.\n" +
                        "\n" +
                        "Number Systems, Logic Gates, Boolean Theorem, Algebraic Simplification, K-map, Combinatorial Circuits, Encoder, Decoder, Combinatorial Circuit Design, Introduction to Sequential Circuits.\n" +
                        "\n" +
                        "Magnetic Circuits, Mutually Coupled Circuits, Transformers, Equivalent Circuit and Performance, Analysis of Three-Phase Circuits, Electromechanical Energy Conversion, Introduction to Rotating Machines.",
                "nil",
                "nil",
                "nil",
                "nil",
                "C. K. Alexander, M. N. O. Sadiku, Fundementals of Electric Circuits, 3rd Edition, McGraw-Hill, 2008."  +
                        "\n" +" W. H. Hayt and J. E. Kemmerly, Engineering Circuit Analysis, McGraw-Hill, 1993." +
                        "\n"+" Donald A Neamen, Electronic Circuits; analysis and Design, 3rd Edition, Tata McGraw-Hill Publishing Company Limited." +
                        "\n"+" Adel S. Sedra, Kenneth C. Smith, Microelectronic Circuits, 5th Edition, Oxford University Press, 2004.M " +
                        "\n"+"R. L. Boylestad and L. Nashelsky, Electronic Devices and Circuit Theory, 6th Edition, PHI, 2001." +
                        "\n"+" M. M. Mano, M. D. Ciletti, Digital Design, 4th Edition, Pearson Education, 2008." +
                        "\n"+" Floyd, Jain, Digital Fundamentals, 8th Edition, Pearson." +
                        "\n"+" A. E. Fitzgerald, C. Kingsley Jr., S. D. Umans, Electric Machinery, 6th Edition, Tata McGraw-Hill, 2003."+
                        "\n"+" D. P. Kothari, I. J. Nagrath, Electric Machines, 3rd Edition, McGraw-Hill, 2004.",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Second Semester","B.Tech",
                "EE102 Basic Electronics Laboratory","Nil","Nil","Nil", "Nil",
                "Experiments using diodes and bipolar junction transistor (BJT): design and analysis of half -wave and full-wave rectifiers, clipping circuits and Zener regulators, BJT characteristics and BJT amplifiers; experiments using operational amplifiers (op-amps): summing amplifier, comparator, precision rectifier, astable and monostable multivibrators and oscillators; experiments using logic gates: combinational circuits such as staircase switch, majority detector, equality detector, multiplexer and demultiplexer; experiments using flip-flops: sequential circuits such as non-overlapping pulse generator, ripple counter, synchronous counter, pulse counter and numerical display.",
                "Nil",
                "Nil",
                "Nil",
                "Nil",
                "A. P. Malvino, Electronic Principles. New Delhi: Tata McGraw-Hill, 1993." +
                        " R. A. Gayakwad, Op-Amps and Linear Integrated Circuits. New Delhi: Prentice Hall of India, 2002." +
                        " R.J. Tocci: Digital Systems; PHI, 6e, 2001.",
                "Nil",
                "Nil",
                "Nil",
                "Nil"));
        Course.add(new EECourseModel("Third Semester","B.Tech ",
                "EE200 Semiconductor Devices and Circuits","EE201 Digital Circuits and Microprocessor","EE202 Digital Circuits Laboratory","EE220 Signal, System and Networks", "Nil",
                "Energy bands; semiconductors; charge carriers: electrons and holes, effective mass, doping. Carrier concentration: Fermi level, temperature dependence of carrier concentration. Drift and diffusion of carriers: excess carriers; recombination and life time, Five equations of carrier transport. p-n Junction: depletion region, forward and reverse-bias, depletion and diffusion capacitances, switching characteristics; breakdown mechanisms; SPICE model. BJT: carrier distribution; current gain, transit time, secondary effects; SPICE model. Metal-semiconductor junctions: rectifying and ohmic contacts. MOSFET: MOS capacitor; Cv-Iv characteristics; threshold voltage; SPICE model. Single stage amplifiers: CE-CB-CC and CG-CD-CS modes of operation, large signal transfer characteristics of BJT and MOSFET, Different types of biasing for BJT and MOSFET, Small signal parameters, Body effect in MOSFET, Parasitic elements, frequency response of CE and CS amplifiers. Analog ICs: DAC, ADC, VCO, PLL and 555-timer",
                "Digital logic families: TTL, MOS, interfacing between logic families; Combinational circuits: multiplexer/ demultiplexer, encoder/ decoder, adder/ subtractor, comparator and parity generators; Sequential circuits: latches and flip-flops (RS, JK, D, T, and Master Slave); Registers; Counters: ripple, ring, and shift register counters; Design and analysis of synchronous sequential finite state machine; Programmable logic devices; Introduction to HDL. Microprocessors: 8085 addressing modes, memory interfacing, interrupts, instructions, timing diagram; Introduction to 8086; Peripheral chips: I/Os, timer, interrupt controller, USART, DMA",
                "Combinational Logic design using decoders and multiplexers; design of arithmetic circuits using adder ICs; Flip flop circuit (RS latch, JK & master slave) using basic gates; Asynchronous Counters, Johnson & Ring counters; Synchronous counters; Sequential Circuit designs (sequence detector circuit), DAC circuit; Assembly language programming of 8085: a) sorting and code conversion, b) matrix multiplication; 8085 interfacing: a) parallel port interface (square wave generation), b) counter and timer interface (polling and using interrupts); ADC/DAC interfacing with 8085.",
                "Signals: classification of signals; signal operations: scaling, shifting and inversion; signal properties: symmetry, periodicity and absolute integrability; elementary signals. Systems: classification of systems; system properties: linearity, time/shift-invariance, causality, stability; continuous-time linear time invariant (LTI) and discrete-time linear shift invariant (LSI) systems: impulse response and step response; response to an arbitrary input: convolution; system representation using differential and difference equations; Eigen functions of LTI/ LSI systems, frequency response and its relation to the impulse response. Signal representation: signal space and orthogonal bases; Fourier series representation of continuous-time and discrete-time signals; continuous-time Fourier transform and its properties; Parseval's relation, time-bandwidth product; discrete-time Fourier transform and its properties; relations among various Fourier representations. Sampling: sampling theorem; aliasing; signal reconstruction: ideal interpolator, zero-order hold, first-order hold; discrete Fourier transform and its properties. Laplace transform and Z-transform: definition, region of convergence, properties; transform-domain analysis of LTI/LSI systems, system function: poles and zeros; stability. Review of network theorems: superposition, Thevenin's, Norton's, reciprocity, maximum power transfer, Millman's and compensation theorems; Network topology: definition of basic terms, incidence matrix, tie-sets, cut-sets; Two port networks: characterization in terms of impedance, admittance, transmission, hybrid parameters and their relationships, interconnection of two port networks; Symmetrical two port network: T and π equivalents, image impedance, characteristic impedance and propagation constant.",
                "Nil",
                "Texts:\n" +
                        "\n" +
                        "R. Pierret, Semiconductor Device Fundamentals, PHI, 2006 P. R. Gray, Paul Hurst, S.H. Lewis and R. G. Meyer, Analysis and Design of Analog Integrated Circuit, John Wiley, 2001. S. Sedra and K. C. Smith, Microelectronic Circuits, Oxford University Press, 1997.\n" +
                        "References:\n" +
                        "\n" +
                        "M. S. Tyagi, Introduction to Semiconductor Materials and Devices, John Wiley & Sons Inc. Michael Shur, Introduction to Electronic Devices, John Wiley & Sons Inc., 2000 R. T. Howe and C. G. Sodini, Microelectronics: An Integrated Approach, Prentice-Hall Inc. 1997. Ben G. Streetman, Solid State Electronic Devices, PHI, 5/e, 2001. J. Singh, Semiconductor Devices - Basic Principles; John Wiley & Sons Inc., 2001.",
                "Texts:\n" +
                        "\n" +
                        "C. H. Roth Jr., “Fundamentals of Logic Design”, 4/e, Jaico Publishers, 2002. J. F. Wakerly, “Digital Design - principles and practices”, 4/e, Pearson Education; 2006. Z. Kohavi, “Switching and Finite Automata Theory”, 2/e, Tata McGraw-Hill, 2008. R. K. Gaonkar, “Microprocessor Architecture, Programming and Applications with the 8085”, Penram International Publishing (India), 2000.\n" +
                        "References:\n" +
                        "\n" +
                        "M. D. Ercegovac, T. Lang, and J.H. Moreno, “Introduction to Digital Systems”, John Wiley, 2000. V. P. Nelson, H. T. Nagle, B. D. Carroll & J. D. Irwin, “Digital Logic Circuit Analysis and Design”, Prentice-Hall, 1995. D. V. Hall, “Microprocessors and Interfacing: programming and hardware”, TMH, 1995.",
                "Niklaus Wirth, Digital Circuit Design: An Introductory Textbook, Sringer, 1995. D. P Leach, A. P. Malvino and G. Saha, Digital Principles and Applications, 2/e, Tata McGraw-Hill, 2006 R. S. Gaonkar, “Microprocessor Architecture, Programming and Applications with the 8085”, Penram International Publishing (India), 2000. TTL IC Data Sheets (www.datasheetarchive.com/).",
                "Texts:\n" +
                        "\n" +
                        "M. J. Roberts, \"Fundamentals of Signals and Systems\", Tata McGraw Hill, 2007. B. P. Lathi,\"Signal Processing and Linear Systems\", Oxford University Press, 1998. M. E. Van Valkenburg, “Network Analysis”, 3/e, Prentice Hall of India, 2003. C. A. Desoer and E. S. Kuh, “Basic Circuit Theory”, McGraw-Hill, 1985.\n" +
                        "References:\n" +
                        "\n" +
                        "A.V. Oppenheim, A.S. Willsky and H.S. Nawab, \"Signals and Systems\", Prentice Hall of India, 2006. R.F. Ziemer, W.H. Tranter and D.R. Fannin, \"Signals and Systems - Continuous and Discrete\", 4/e, Prentice Hall, 1998. Simon Haykin, Barry van Veen, \"Signals and Systems\", John Wiley and Sons, 1998. F. F. Kuo, “Netwok Analysis and Synthesis”, 2/e, Weily India, 2007. K. S. Suresh Kumar, “Electric Circuits and Networks”, Pearson Education, 2009.",
                "Nil"));
        Course.add(new EECourseModel("Third Semester HSS Elective","B.Tech ",
                "HS201 INTRODUCTORY MICROECONOMICS","HS221 FUNDAMENTALS OF LINGUISTICS SCIENCE","HS231 INTRODUCTORY SOCIOLOGY","HS241 General Psychology", "Nil",
                "Introduction:Why Economics, The Central Economic Problem, Production Possibility Curve (PPC)\n" +
                        "\n" +
                        "Overview of Markets:Demand and Supply, Elasticity, Efficiency and Equity, Markets in Action\n" +
                        "\n" +
                        "Determinants of Demand and Supply:Utility and Demand, Production and Costs\n" +
                        "\n" +
                        "Markets for Goods and Services:Competition, Monopoly, Monopolistic Competition and Oligopoly\n" +
                        "\n" +
                        "Markets and Government:Externalities, Public Goods and Taxes, Factor markets, Income distribution",
                "Introduction:Language; Linguistics; Language Learning\n" +
                        "\n" +
                        "Phonetics (Sound Systems):Mechanism of Speech Production, Consonants, Vowels , Phonotactic Rules, Phonology: Phonemes\n" +
                        "\n" +
                        "Morphology:Morphemes, Structure of Words\n" +
                        "\n" +
                        "Syntax:Constituents of a Sentence, Structure of a Sentence; Grammar; Acceptability and Grammaticality; Principles and Parameters; Prescriptive, Descriptive, and Explanatory Adequacy, Syntactic Tools; Principles of modern linguistics with special reference to English and Hindi syntax\n" +
                        "\n" +
                        "Use of language:Language in Literature, Media, Language in Advertisement\n" +
                        "\n" +
                        "Sociolinguistics:Language is Social Context; Multilingualism\n" +
                        "\n" +
                        "Language and Politics:Language in Constitution; Language and Dialect\n" +
                        "\n" +
                        "Psycholinguistics:Language Acquisition; Universal Grammar\n" +
                        "\n" +
                        "Semantics 2:Language Change and Language Variation, Language and Computers",
                "Introduction:Sociological Imagination; Subject matter of Sociology\n" +
                        "\n" +
                        "Theoretical Practice:Durkheim (Foundations of the Science of Society), Weber (Economy and Society),Marx (Political Economy), Foucault (Practices and Knowledge), Butler (Gender Performativity), & Burawoy (Public Sociology).\n" +
                        "\n" +
                        "Methodology and Methods:Qualitative, Quantitative, and Mixed\n" +
                        "\n" +
                        "Indian Society::Eminent Indian Sociologists; Caste, Class, and Tribe; Women and Children; Health and Education; Science, Technology and Society; Media and Migration; Globalization and Social Change; Diaspora; Bihar- a case study.",
                "Aim of the Course\n" +
                        "\n" +
                        "This course covers some of the biological, psychological, and individual factors which influence human thinking, beliefs, and behaviour. This knowledge will help students in understanding their own behaviours and behaviours of others. They can also apply psychological theories and principles in their workplace and practical life.\n" +
                        "\n" +
                        "Course Contents\n" +
                        "\n" +
                        "Introduction:Brief History of Psychology; Human Mind and Human Behaviour; Definition; Methods; Scope and Subject Matter.\n" +
                        "\n" +
                        "Perception:Process; Determinants of Perception; Gestalt Theory; Extra-Sensory Perception; Intuitive Judgement.\n" +
                        "\n" +
                        "Intelligence:Concept of Intelligence; Factors and Measurement of Intelligence; Successful Intelligence and Emotional Quotient (EQ).\n" +
                        "\n" +
                        "Learning:Process of Learning, Retention and Recall; Theories of Learning; Effective Methods of Learning.\n" +
                        "\n" +
                        "Information Processing Approach; Sensory Information Stage; Short-Term and Long-Term Memory; Process of Forgetting.\n" +
                        "\n" +
                        "Thinking:Nature of Thinking; Concept Formation; Problem Solving; Creative Thinking; Day Dreaming.\n" +
                        "\n" +
                        "Personality:Definition; Determinants of Personality; Theories of Personality; Assessment of Personality.\n" +
                        "\n" +
                        "Abnormality:Normal and Abnormal; Cause and Significance of Symptoms and Mental Diseases; Mental Health; Spiritual Counselling.",
                "Nil",
                "Texts:\n" +
                        "\n" +
                        "Paul A. Samuelson and William Nordhaus , Economics, Tata M.Hill, 2005.\n" +
                        "References:\n" +
                        "\n" +
                        "A.Koutsoyiannis, Modern Microeconomics, Macmillan, 2008. Richard G.Lipsey and Alec Chrystals, Oxford, 2007. Microeconomics: An Integrated Approach, David Besanko and Ronald R. Braeutigam ,John Wiley and Sons, 2002",
                "Bloomfield, L. 1933 Language, pp. 21-41. Holt, Rinehart and Winston Chomsky, N. 1965 Aspects of the Theory of Syntax, pp. 3-15, 18-27, 47-59. MIT Press Farmer, Ann and Richard Demers 2001 A Linguistics Workbook MIT Press",
                "Alex Inkeles, What is Sociology? An Introduction to the Discipline and Profession New Delhi: Prentice-Hall of India, 1997 Anthony Giddens, Sociology (Sixth Edition) Cambridge: Polity Press, 2009 M.N.Srinivas, Social Change in Modern India, New Delhi: Orient Longman, 1985 S. C. Dube, Indian Village London: Routledge, 1955",
                "McConnell, J.V. Understanding Human Behaviour (6th Ed.). New York: Holt, Rinehart and Winston. Myers, D.G. (2010). Psychology (9th Edition). New York: Worth Publishers. Griggs, R.A. (2010). Psychology: A Concise Introduction. New York; Worth Publishers. Brown, J.F. & Mogan, C.T. (2011). The Psychodynamics of Abnormal Behaviour. New York: Literary Licensing, LLC.",
                "Nil"));
        Course.add(new EECourseModel("Fourth Semester","B.Tech ",
                "EE203 Analog Integrated Circuits","EE204 Analog Circuits Laboratory","EE230 Principal of Communication","EE280 Electrical Machines", "EE281 Electrical Machines Laboratory",
                "Frequency response of amplifiers: high frequency device models, frequency response, GBW, methods of short circuit and open circuit time constants, dominant pole approximation; Feedback amplifiers: basic feedback topologies and their properties, analysis of practical feedback amplifiers, stability; Power amplifiers: class A, B, AB, C, D, E stages, output stages, short circuit protection, power transistors and thermal design considerations; Differential amplifiers: DC and small signal analysis, CMRR, current mirrors, active load and cascode configurations, frequency response; case study: 741 op-amp - DC and small signal analysis, frequency response, frequency compensation, GBW, phase margin, slew rate, offsets; CMOS realizations: current source, sink and mirrors, differential amplifiers, multistage amplifiers; Signal generation and waveform shaping: sinusoidal oscillators- RC, LC, and crystal oscillators, Schmitt trigger; Analog subsystems: analog switches, voltage comparator, voltage regulator, switching regulator, bandgap reference voltage source, analog multiplier, filter approximations: Butterworth, Chebyshev and elliptic, first order and second order passive/active filter realizations.",
                "Experiments using BJTs, FETs, op-amps and other integrated circuits: Multistage amplifiers, automatic gain controlled amplifiers, programmable gain amplifiers; frequency response of amplifiers; voltage regulator with short circuit protection; phase‑locked loop; waveform generators; filters.",
                "Basic blocks in a communication system: transmitter, channel and receiver; baseband and passband signals and their representations; concept of modulation and demodulation. Continuous wave (CW) modulation: amplitude modulation (AM) - double sideband (DSB), double sideband suppressed carrier (DSBSC), single sideband suppressed carrier (SSBSC) and vestigial sideband (VSB) modulation; angle modulation - phase modulation (PM) & frequency modulation (FM); narrow and wideband FM. Pulse Modulation: sampling process; pulse amplitude modulation (PAM); pulse width modulation (PWM); pulse position modulation (PPM) ; pulse code modulation (PCM); line coding; differential pulse code modulation; delta modulation; adaptive delta modulation. Noise in CW and pulse modulation systems: Receiver model; signal to noise ratio (SNR); noise figure; noise temperature; noise in DSB-SC, SSB, AM & FM receivers; pre-emphasis and de-emphasis, noise consideration in PAM and PCM systems. Basic digital modulation schemes: Phase shift keying (PSK), amplitude shift keying (ASK), frequency shift keying (FSK) and Quadrature amplitude modulation (QAM); coherent demodulation and detection; probability of error in PSK, ASK, FSK & QAM schemes. Multiplexing schemes: frequency division multiplexing; time division multiplexing.",
                "Magnetic circuits and transformer including 3-phase transformers; modeling of D.C. machines; phasor diagram of cylindrical rotor and salient pole machines- electromagnetic and reluctance torque, response under short circuit conditions; modeling of induction machines- derivation of equivalent circuits, dynamics under load change, speed reversal and braking, unbalanced and asymmetrical operation; single phase induction motor and applications in domestic appliances; modeling of synchronous machines - equivalent circuit, d-q transformations, short circuit studies in synchronous machines; variable reluctance, permanent magnet, stepper motors and their applications.",
                "Open circuit and short circuit tests of single phase transformer, three phase transformer connections, open circuit test and load characteristics of DC generator, speed control and output characteristics of DC motor, no load, blocked rotor and load tests on induction motor, open circuit and short circuit tests of an alternator.",
                "Texts:\n" +
                        "\n" +
                        "S. Smith, \"Microelectronics Circuits”, 5/e, Oxford, 2005 P. Gray, P. Hurst, S. Lewis, and R. Meyer, \"Analysis & Design of Analog Integrated Circuits,\" 4/e, Wiley, 2001.\n" +
                        "References:\n" +
                        "\n" +
                        "B. Razavi, Design of Analog CMOS Integrated Circuits, McGraw Hill 2001. D. Johns, K. Martin, \"Analog Integrated Circuit Design,\" Wiley, 1997. R. A. Gayakwad, Op-Amps and Linear Integrated Circuit, Prentice Hall of India, 2002. B. Razavi, RF Microelectronics, Prentice-Hall, 1998. P. E. Allen and D. R. Holberg, CMOS Analog Circuit Design, 2/e, Oxford University Press, 1997.",
                "A. P. Malvino, Electronic Principles, Tata McGraw-Hill, 1993. R. A. Gayakwad, Op-Amps and Linear Integrated Circuits, Prentice Hall of India, 2002.",
                "Texts:\n" +
                        "\n" +
                        "J. G. Proakis and M. Salehi, Communication system engineering, 2/e, Pearson Education Asia, 2002. R. E. Ziemer, W. H. Tranter, Principles of Communications: Systems, Modulation, and Noise, 5/e, John Wiley & Sons, 2001. Simon Haykin, Communication Systems, 4/e, John Wiley & Sons, 2001.\n" +
                        "References:\n" +
                        "\n" +
                        "K. Sam Shanmugam, Digital and Analog Communication Systems, John Wiley and Sons, 1979. A. B. Carlson, Communication Systems,3/e, McGraw Hill, 1986. B. P. Lathi, Modern Analog and Digital Communication systems, 3/e, Oxford University Press, 1998. H. Taub and D. L. Schilling, Principles of Communication Systems, 2/e, McGraw Hill, 1986.",
                "I. L. Kosow, Electrical Machinery and Transformers, 2/e, Prentice- Hall of India Pvt. Ltd., 2003. D. P. Kothari and I. J. Nagrath, Electric Machines, 3e, Tata McGraw-Hill, 2004. B. S. Guru and H. R. Hiziroglu, Electrical Machinery and Transformers, 3/e, Oxford University Press, 2003. R. K. Rajput, Electrical Machines, 3/e, Laxmi Publications (P) Ltd., 2003.",
                "Stephen Chapman, Electric Machinery Fundamentals, 4/e, McGraw-Hill, 2003. C. S. Indulkar, Laboratory Experiments in Electrical Power Engineering, Khanna Publishers, 2003."));


        Course.add(new EECourseModel("Fourth Semester Science Elective ","B.Tech ",
                "GREEN CHEMISTRY AND TECHNOLOGY","Algebra and Number Theory","INTRODUCTION TO COMPUTATIONAL TOPOLOGY","INTRODUCTION TO NUMERICAL METHODS", "OPTIMIZATION TECHNIQUES",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Fifth Semester","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Fifth Semester Open Elective","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Sixth Semester", "B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Sixth Semester HSS Elective", "B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Seventh Semester","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Seventh Semester Open Elective","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Eight Semester ","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Eight Semester Departmental Elective","B.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("First Semester ","M.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Second Semester ","M.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Third Semester ","M.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Fourth Semester ","M.Tech ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Ph.D. Syllabus (Odd Semester) ","Ph.D ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));
        Course.add(new EECourseModel("Ph.D. Syllabus (Even Semester) ","Ph.D ",
                "1","2","3","4", "5",
                "a",
                "b",
                "c",
                "d",
                "e",
                "p",
                "q",
                "r",
                "s",
                "s"));




        EECourseAdapter adapter = new EECourseAdapter(getContext(),Course);
        EECourseRecyclerview.setAdapter(adapter);
        return View;




    }


}