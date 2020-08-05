package example.guava;

import com.google.common.base.Splitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xuelu
 * 2020-07-21.
 */
public class TestSets {

    public static void main(String[] args) {
        String str = "457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,487446_258076977，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,2090996_258081799，outOrderCode,457671_124183318，outOrderCode,579664_124172476，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,457671_124183318，outOrderCode,487446_258076977，outOrderCode,457671_124183318，outOrderCode,2090996_258081799，outOrderCode";
        Splitter splitter = Splitter.on(",");
        List<String> list = splitter.splitToList(str);
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }
}
