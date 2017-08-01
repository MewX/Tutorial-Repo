import java.util.*;

public class FamilyTravel {
    public static void main(String[] args) {
        System.out.println(new FamilyTravel().shortest(new String[] {"00ac","000a","a00c","cac1"}));
        System.out.println(new FamilyTravel().shortest(new String[] {"0ze","z0c","ec0"}));
        System.out.println(new FamilyTravel().shortest(new String[] {"0zc","z0e","ce0"}));
        System.out.println(new FamilyTravel().shortest(new String[] {"0Zej0","Z0fkh","ef00d","jk00i","0hdi0"}));
        System.out.println(new FamilyTravel().shortest(new String[] {"00z00","0000a","z00bb","00b0b","0abb0"}));
        System.out.println(new FamilyTravel().shortest(new String[] {"000a", "00a0", "0a0a", "a0a0"}));
        System.out.println(new FamilyTravel().shortest(new String[] {
                "0000c00000G00i00m0o0ZK0j00f0q00k0o00JtLnjZ00LXht00",
                "00T0TTTTT0T0T000TTT000000TT00TTTTT0000TTTT00T0TT0T",
                "0T0nCY00P0F0G0a000m0rM0J0lz00PU0c0w0b0q000u0vQ0BeR",
                "00n0f000J0xtdu0iv0M0bM0000000hi0KTvAF0aX0m0XOc0000",
                "cTCf0DL0p0000W000X0AQ0e0Z0Y000i0000O0l0s00c0B0O0Dp",
                "0TY0D00Do000D0p00T0BS0deO0NCu0oNxqR0V0r00V00d0000h",
                "0T00L00G0y0D0Od00v0FVX0u00ruO0NGjfj00p0000Qs00b000",
                "0T000DG0n0nKy0t0Hnxy0Hk0Xr00b000ybP00Gil00fVt00000",
                "0TPJpo0n0N0tb0nD0zSfzN0Zp0Q0000O00000MG0o0ul00FIj0",
                "000000y0N0X000HjhC0v00XV00s0D00y0r0x0WfE000000000A",
                "GTFx000n0X0jEP0t0C0H0Hl00ooCm00p0k00000OLeq0A00S00",
                "000t00DKt0j0bT00aui0V0j00vDagKB0000e00Qm00hvbV0A0E",
                "0TGd0D0yb0Eb0h000nN00000Dm0e00IX0SVZ000x0Il0VZ00Bx",
                "i00uW0O000PTh000U0j00nL000R0pG000a0VOozuMb000mMWbB",
                "00a00pdtnH00000K00h0iF00uL00h0Q000CP00c000000tI0Kr",
                "000i0000Djt000K0QFeAf000QeAxqFlwg000WlU00Q0k0C000e",
                "mT0v000H0h0a0U0Q0cY00OB0XX000ECX00A0C00vM000nGe000",
                "0T00XTvnzCCun00Fc00d0ux0gc000WWDg0D00000XRND00h0iz",
                "oTmM000xS00iNjheY00A00L000Oa0000svQ0KE000i00ZDs00k",
                "0000ABFyfvH0000A0dA00bSW0tyo00PbcA0GH0g0000J0vry0L",
                "Z0rbQSV0z00V00if00000vn00000i0P0WA0l0g0usLM0p0P0iF",
                "K0MM00XHN0H00nF0Ou0bv00f00UzIe00d0C00cj0SH0b0o0w0l",
                "0000ed0k0Xlj0L00BxLSn00A0F0B0cr0R0hDwYYMU0x0lD0zg0",
                "j0J00eu0ZV000000000W0fA00i000Z0g0l00ojrAly00c00c0S",
                "0000ZO0Xp000D0uQXg0000000k00p0obVqJ0ac0V0wij0c000p",
                "0Tl0000r00ovm0LeXc0t00Fik000ffG0W0g00heRjw0QmB0e00",
                "fTz0YNr0QsoD0R0A00Oy0U000000mV00Uz0Dnk0o00a00q0x00",
                "00000Cu000Cae00x00ao0zB000000HP0pdb0Sg0qwzG0DSw000",
                "q0000uOb0Dmg0phq0000iI00pfm000000b0O0000l0h000000e",
                "0TPh0000000K0G0FEW000ecZ0fVH000f00WWM0B0000i00R0i0",
                "0TUiioN0000BI0QlCW0PP0r0oG0P0000TxK0b0AEiGEYBw00O0",
                "kT000NG0Oyp0X00wXD0b000gb0000f00r00rYFh0crQEI0GN00",
                "0TcK0xjy0000000g0gscWdR0VWUp00Tr0OH00px0KX0vEK0Ngy",
                "oT0T0qfb0rk0Sa0000vAA00lq0zdb0x0O000I0DSS00E000n00",
                "00wv0RjP0000V0C0ADQ00Ch0Jg0b0WK0H000sMWN0F0000Tpt0",
                "000AO0000x0eZVP0000Gl0D000D0OW0r00000s000YArIl0T00",
                "J0bF0V0000000O0WC0KH00woa0nS0MbY0Is00c0Eu000KZe0Rb",
                "t000l0pGMW000o0l00E0gcYjchkg000Fp0Msc0YrPZF000Y000",
                "LTqa0r0iGf0Q0zcU000g0jYr0e000BAhxDW00Y0q000K0X00vm",
                "nT0Xs00l0EOmxu00v000u0MAVRoq00E00SN0Erq0A000q0000O",
                "jT000000o0L00M00MX00sSUl0j0wl0icKS00uP0A0s0DD0Fr00",
                "ZT0m0V0000e0Ib0Q0Ri0LH0yww0z00GrX0FY0Z00s00Q00j0Id",
                "00u0c0Qfu0qhl0000N00M0x0i0aGh0EQ000A0F00000n0MX0j0",
                "000X00sVl00v000k0D0J0b00jQ000iYEvE0r00K0DQn000000j",
                "LTvOBd0t00AbV000n0Z0p0lc0m0D00BIE00IK00qD0000vO000",
                "X0Qc0000000VZmtCG0Dv0oD0cBqS00w0K00lZ0X000M0v00000",
                "hT00O0b0F0000MI0ehsrP000000w0R0G00T0eY00FjX0O00C00",
                "tTB00000I0SA0W00000y0wzc0ex0000NNnpT0000r00000C0pL",
                "00e0D000j000BbK00i00i0g000000iO0g0t0R0v00Ij0000p0T",
                "0TR0ph000A0ExBre0zkLFl0Sp000e000y000b0mO0d0j000LT0"}));
	}

    private static int MAX = 1000000;
    private int getDistance(int city1, int city2, String[] edges) {
        final char c = edges[city1].charAt(city2);
        if ('a' <= c && c <= 'z') return c - 'a' + 1;
        else if ('A' <= c && c <= 'Z') return c - 'A' + 27;
        else return -1; // if no path, return -1
    }

    private int dfs(int beg, final int prevLen, final int pre, final int[][] dist, final int[][][] save) {
        if (beg == 1) return 0; // found it!
        else if (save[beg][prevLen][pre] != -1) return save[beg][prevLen][pre];

        int shortest = MAX;
        for (int i = 1; i < dist.length; i ++) {
            // shoudn't be larger
            if (i == pre || dist[beg][i] > prevLen) continue;

            int temp = dfs(i, dist[beg][i], beg, dist, save);
            save[beg][prevLen][pre] = shortest = Math.min(shortest, temp + dist[beg][i]);
            // System.out.format("+save[%d][%d] = %d\n", beg, prevLen, save[beg][prevLen]);
        }
        return shortest;
    }

    public int shortest(String[] edges) {
        final int cityNum = edges.length;
        int[][] dist = new int[cityNum][cityNum]; // default 0
        int[][][] save = new int[cityNum][54][cityNum]; // for DP, [cur][prevLen][previous]
        for (int i = 0; i < cityNum; i ++) {
            for (int j = 0; j < cityNum; j ++) {
                if (j == i) continue; // by default [][] is 0
                int temp = getDistance(i, j, edges);
                dist[i][j] = temp!= -1 ? temp : MAX;
            }
            for (int j = 0; j < 54; j ++)
                for (int k = 0; k < cityNum; k ++)
                save[i][j][k] = -1;
        }

        int temp = dfs(0, 53, 0, dist, save);
        return temp >= MAX ? -1 : temp;
    }
}
