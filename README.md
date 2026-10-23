# Operating Systems Programming Assignment — Synchronization

**Student:** Chirag Sharma  
**USN:** NNM24IS060  
**Course:** Operating System  
**Institute:** NMAM Institute of Technology, Nitte  
**Submitted to:** Dr Jason Elroy Martis

## Project overview

This assignment demonstrates two classical synchronization problems using Java:

1. Readers–Writers with semaphores
2. Readers–Writers with monitors
3. Dining Philosophers with semaphores
4. Dining Philosophers with monitors

The project includes the submitted report, Java source implementations, Colab notebooks for visual simulation, and HTML logs/demo assets.

## Files

- `report/Assignment_Report.docx` — assignment report
- `notebooks/Live_Readers_Writers_Semaphore_Colab.ipynb`
- `notebooks/Live_Readers_Writers_Monitor_Colab.ipynb`
- `notebooks/Live_Dining_Philosophers_Colab.ipynb`
- `notebooks/Live_Dining_Philosophers_Monitor_Colab.ipynb`
- `src/` — Java implementation files
- `html/` — generated execution logs
- `html-demo/semaphore_animations.html` — interactive HTML demo

## Running the Colab simulations

1. Download/open one of the notebooks in `notebooks/` using Google Colab.
2. Run its main code cell.
3. The notebook compiles and runs the Java synchronization implementation and updates its visualization from program events.

A Java compiler is required in the notebook runtime. The notebooks are provided as interactive demonstrations; run each one in your own runtime before relying on its output for assessment.

## Synchronization concepts

- **Semaphore:** explicit acquire/release control over access.
- **Monitor:** shared state and synchronization logic organized using Java synchronized methods/blocks and wait/notification.
- **Mutual exclusion:** prevents conflicting simultaneous access.
- **Race condition:** an outcome depends on the timing/order of concurrent operations.
- **Deadlock:** progress stops because threads wait for resources held by one another.

## Repository

https://github.com/ChiragSharma1606/os-2
