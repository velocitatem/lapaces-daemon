package velo.q.structure.testing;

import org.junit.jupiter.api.Test;
import velo.q.structure.DataPoint;
import velo.q.structure.data.Finance;

class FinanceTesting {

    @Test
    void test() {
        DataPoint pt = Finance.forex();
        Object o = pt.fetch(new Object[]{"USD", "JPY"});
        System.out.println(pt.stringify(o));
    }

}
