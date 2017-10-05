package level4.earthquake.task;

import level4.earthquake.task.sort.QuakeSortInPlace;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EarthQuakeClient eqc = new EarthQuakeClient();
		//eqc.createCSV();
		//eqc.bigQuakes();
		//eqc.closeToMe();
		//eqc.quakesOfDepth();
		//eqc.quakesByPhrase();
		ClosestQuakes cq = new ClosestQuakes();
		//cq.findClosestQuakes();
		LargestQuakes lq = new LargestQuakes();
		//lq.findLargestQuakes();
		EarthQuakeClient2 eqc2 = new EarthQuakeClient2();
		//eqc2.quakesWithFilter();
		//eqc2.testMatchAllFilter2();
		//eqc2.quakesWithFilter();
		QuakeSortInPlace qsp = new QuakeSortInPlace();
		//qsp.testSort();
		//qsp.sortByLargestDepth();
		DifferentSorters ds = new DifferentSorters();
		//ds.sortWithCompareTo();
		//ds.sortByTitleAndDepth();
		ds.sortByLastWordInTitleThenByMagnitude();
	}

}
